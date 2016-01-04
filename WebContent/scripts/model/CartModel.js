app.service("CartModel",function($http,ConfigService,$q){
	var baseUrl="Cart";
	this.add = function(cartItem){
		return $http.post(ConfigService.getUrl(baseUrl)+"/AddProduct",cartItem).then(function(res){
			if(typeof res.data =='object'){
				return res.data
			}
			else {
				$q.reject(res.data);
			}
		})
	}
	
	this.getById= function(id){
		return $http.get(ConfigService.getUrl(baseUrl)+"/GetCart",id).then(function(res){
			if(typeof res.data =='object'){
				return res.data
			}
			else {
				$q.reject(res.data);
			}
		})
	}
});