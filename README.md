---
# Automotive Parts E-Commerce Project

###
```sh
This project will create a simple
Automotive Parts E-Commerce Project web application
backend using Spring Boot, Spring Data JPA vs. and 
H2DB database.
```

# Dockerize `docker-compose & Dockerfile`
#### `Docker Compose`
```yml
version: '1.0'

services:
  app:
    container_name: AutomotivePartsE-Commerce.jar
    image: AutomotivePartsE-Commerce.jar
    restart: always
    build: ./
    ports:
      - "8080:8080"
```
#### `Dockerfile`
```dockerfile
FROM adoptopenjdk/openjdk19
ARG JAR_FILE=AutomotivePartsE-Commerce-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} AutomotivePartsE-Commerce.jar
ENTRYPOINT ["java","-jar","/AutomotivePartsE-Commerce.jar"]
```
#### `Swagger ui`
```java
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openAPIMethod(){
        return new OpenAPI().info( new Info()
                .title("AutomotivePartsE-Commerce")
                .description("AutomotivePartsE-Commerce Backend Project")
                .version("V1.0")
                .contact(new Contact()
                        .name("Murat")
                        .url("www.mrtark.com")
                        .email("contact@mrtark.com"))
                .termsOfService("www.mrtark.com")
                .license(new License()
                        .name("Licence")
                        .url("www.mrtark.com"))
        );
    }
}
```

![swagger](https://github.com/mrtark/AutomotivePartsE-Commerce/assets/62309785/5bddbf1f-99a6-402b-bd62-5250e94d516e)


### Binding Backend and Frontend with `API` in `React` using `Axios`.
```js
class UserService{

    createUserApi(userRegisterDto){
        return axios.post(User_Url + "/user", userRegisterDto);
    }
    userListApi(){
        return axios.get(User_Url + "/userList");
    }
    findUserApi(id){
        return axios.get(User_Url + "/" + id);
    }
    updateUserApi(id,userRegisterDto){
        return axios.put(User_Url + "/" + id,userRegisterDto);
    }
    deleteUserApi(id){
        return axios.delete(User_Url + "/" + id);
    }
    emailSearchApi(email){
        return axios.get(User_Url + "/userEmail" + email);
    }
}
export default new UserService();
```
```js
class ProductService{

    createProductApi(productDto){
        return axios.post(Product_Url + "/create",productDto);
    }

    listProductApi(){
        return axios.get(Product_Url + "/list");
    }

    findProductApi(id){
        return axios.get(Product_Url + "/product" + id);
    }

    deleteProductApi(id){
        return axios.delete(Product_Url + "/product" + id);
    }

    updateProductApi(id,productDto){
        return axios.put(Product_Url + "/product" + id,productDto);
    }

    productIdFindApi(id){
        return axios.get(Product_Url +"/productID" + id );
    }
}
export default new ProductService();
```
#
# Getting Started with Create React App

This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

## Available Scripts

In the project directory, you can run:

### `npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in your browser.

The page will reload when you make changes.\
You may also see any lint errors in the console.

### `npm test`

Launches the test runner in the interactive watch mode.\
See the section about [running tests](https://facebook.github.io/create-react-app/docs/running-tests) for more information.

### `npm run build`

Builds the app for production to the `build` folder.\
It correctly bundles React in production mode and optimizes the build for the best performance.

The build is minified and the filenames include the hashes.\
Your app is ready to be deployed!

See the section about [deployment](https://facebook.github.io/create-react-app/docs/deployment) for more information.

### `npm run eject`

**Note: this is a one-way operation. Once you `eject`, you can't go back!**

If you aren't satisfied with the build tool and configuration choices, you can `eject` at any time. This command will remove the single build dependency from your project.

Instead, it will copy all the configuration files and the transitive dependencies (webpack, Babel, ESLint, etc) right into your project so you have full control over them. All of the commands except `eject` will still work, but they will point to the copied scripts so you can tweak them. At this point you're on your own.

You don't have to ever use `eject`. The curated feature set is suitable for small and middle deployments, and you shouldn't feel obligated to use this feature. However we understand that this tool wouldn't be useful if you couldn't customize it when you are ready for it.