# Introduction
This is a boiler plate project for FSD Certification Practice Check. Fork this project to the group CHN18IJ002 and create the below specified issues in the forked project.

| **Issue Title** | **Issue Description** |
|-----------|-------------------|
| 1. Implement the functionality of the application | Create a website for users to signup and search new articles in a lively manner. Refer detailed description below this table. |
| 2. Analysis and Design | Define Screen Layout, ER Diagram, Classes and Method signatures. Include the documentation in README.md section of the project. |
| 3. Implement Repository and Service Layer | Create database and implement Service Layer using Hibernate. Unit Testing of the service method should be done using Mockito. Document the steps to build, unit test and deploy in Wiki. |
| 4. Implement Rest Controller | Create the Restful Web Service Controller using Spring MVC and create end to end tests using MockMvc library available in Spring. Document the steps to build, unit test and deploy. |
| 5. Implement Authentication Service | Modify the test cases based on inclusion of Authentication. |
| 6. Implement CI/CD | Automate the deployment of WAR using Jenkins. |
| 7. Implement Front End and consume Rest Services | Implement front end using Angular with responsive web design. Implement Unit Testing using Karma. Implement end to end testing with Protractor. |
| 8. Document the steps for build and deployment | Create a subheading for this in README.md and include the steps to deploy. |
| 9. Create docker compose for this application | |

# Application Functionality in detail (Include this in issue description of forked project)

## Role: News Analyst
1. Signup (Choose language during signup)
2. Login
3. Search news articles based on the language chosen during signup (use https://newsapi.org to retrieve live new data.)
4. Add an article as favorite
5. List favorite articles
6. Remove a favorite article
7. Logout

## Role: Admin
1. Login
2. Search New Analyst
3. Blacklist New Analyst
4. Logout



# Analysis and Design 

## Screen Layout for Signup page.

1. Header - Create an Account to Login...
2. Name [input type ="text"].
3. Email [input type ="text"].
4. Password [input type ="password"].
5. SignUp button [input type ="button"].
6. Model for confirmation message [id="signupconfirmation

## Screen Layout for Login page.

1. Header - Login Page...
2. Name [input type ="text"].
3. Email [input type ="text"].
4. Password [input type ="password"].
5. Login button [input type ="button"].

## DataBae for ArticleSearch

### Table Name - user

| **Fiels** | **Data Type** |
|-----------|-------------------|
| 1. us_id. | int primary key not null|
| 2. us_name. | varchar(70) not null|
| 3. us_email. | varchar(255) not null|
| 4. us_ur_id. | int not null|
| 5. us_password. | int not null|
| 6. us_art_id. | int not null
| 7. us_lan_id. | int not null|

### Table Name - user_role

| **Fiels** | **Data Type** |
|-----------|-------------------|
| 1. ur_id | int primary key not null |
| 2. ur_role | varchar(10) not null |


### Table Name - language

| **Fiels** | **Data Type** |
|-----------|-------------------|
| 1. lang_id | int primary key not null |
| 2. lang_name | varchar(45) not null |



### Table Name - article

| **Fiels** | **Data Type** |
|-----------|-------------------|
| 1. art_id | int primary key not null |
| 2. art_name | VARCHAR(100) not null |
| 2. art_title | VARCHAR(255) not null |
| 2. art_desc | VARCHAR(255) not null |
| 2. art_content | VARCHAR(255) not null |
| 2. art_author | VARCHAR(70) not null |
| 2. art_url | VARCHAR(255) not null |
| 2. art_urlToImage | VARCHAR(255) not null |
| 2. art_publishedAt | DATETIME not null |

### Table Name - favourite_article

| **Fiels** | **Data Type** |
|-----------|-------------------|
| 1. fa_id | int primary key not null |
| 2. fa_art_id | int not null |
| 2. fa_us_id | int not null |














