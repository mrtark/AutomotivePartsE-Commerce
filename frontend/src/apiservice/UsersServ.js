import axios from "axios";
const User_Url = "/api/user/v1";

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