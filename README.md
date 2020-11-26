# **Image Uploader Application**

It is a web application that uses REST API and Java library to upload photos to the cloud and MySQL to save links and create photo galleries.

## Used technologies:
* Spring Web MVC
* Spring Data JPA
* Spring Boot
* Spring Security
* Repository
* HTML
* MySQL
* Cloudinary.com REST API and Java library
* IntelliJ Idea
* Visual Studio Code

## Description of Application

### Application start page. It is designed so that access to upload photos is available to the user of the Admin type, and viewing the gallery is available to the user of the User type.

![alt text](/.readmeimages/image1.jpg)

### The Cloudinary.com website has a REST API for Java programs. This allows you to upload photos in the cloud.

![alt text](/.readmeimages/image2.jpg)

### The website also allows you to view photos stored in the cloud.

![alt text](/.readmeimages/image3.jpg)

### Application Event Listener is launched when the entire application is started and creates two users: AdminJan and UserJan. The password is encrypted with BCryptPasswordEncoder and saved in the MySQL database.

```java
@Bean
public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
}

@EventListener(ApplicationReadyEvent.class)
public void get() {
	AppUser appUser = new AppUser("UserJan", passwordEncoder()
			.encode("User123"), "ROLE_USER");
	AppUser appAdmin = new AppUser("AdminJan", passwordEncoder()
			.encode("Admin123"), "ROLE_ADMIN");
	appUserRepo.save(appUser);
	appUserRepo.save(appAdmin);
}
```

### Endpoint permission is implemented with Spring Security. The / upload path is available to the Admin user; path / gallery is available to User, while home page, login and logout is available to everyone.

```java
@Override
protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests()
			.antMatchers("/upload").hasRole("ADMIN")
			.antMatchers("/gallery").hasRole("USER")
			.antMatchers("/").permitAll()
			.antMatchers("/logout").permitAll()
			.and()
			.formLogin().permitAll()
			.and()
			.csrf().disable()
			.httpBasic()
			;
}
```

### When the application is started, two records are created in the 'app_user' table with information about the two types of users.

![alt text](/.readmeimages/image6.jpg)

### The 'image' table is empty because no photos have been added.

![alt text](/.readmeimages/image7.jpg)

### After clicking 'Upload [Admin]' we can add the path to the photo on the hard drive.

![alt text](/.readmeimages/image8.jpg)

### To perform the operation it is necessary to login with the Admin type user.

![alt text](/.readmeimages/image9.jpg)

### Photo added to the cloud.

![alt text](/.readmeimages/image10.jpg)

### Link to the photo added to the database.

![alt text](/.readmeimages/image11.jpg)

### The page after logging out.

![alt text](/.readmeimages/image12.jpg)

### After clicking 'Gallery [User]' it is necessary to log in as User.

![alt text](/.readmeimages/image13.jpg)

### A photo gallery is created based on the links stored in the database.

![alt text](/.readmeimages/image14.jpg)

### Cloud state after adding some photos.

![alt text](/.readmeimages/image15.jpg)

### 'image' table state after adding some photos.

![alt text](/.readmeimages/image16.jpg)

### Gallery after adding some photos.

![alt text](/.readmeimages/image17.jpg)
