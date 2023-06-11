import axios from "axios";
const Product_Url = "/api/product/v1";

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