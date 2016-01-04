app.service("CartItemModel",function($http,ConfigService,$q){
	var baseUrl="Cart";
	this.add = function(product, cartItem){
		return $http.post(ConfigService.getUrl(baseUrl)+"/AddProduct",product, cartItem).then(function(res){
			if(typeof res.data =='object'){
				return res.data
			}
			else {
				$q.reject(res.data);
			}
		})
	}
	
	this.getById= function(id){
		return $http.post(ConfigService.getUrl(baseUrl)+"/GetCart",id).then(function(res){
			if(typeof res.data =='object'){
				return res.data
			}
			else {
				$q.reject(res.data);
			}
		})
	}
	
	this.getAll=function(data){
		return $http.post(ConfigService.getUrl(baseUrl)+"/GetCartItems",{"id":data.userId})
	}
});