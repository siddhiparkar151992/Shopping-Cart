app.service("cartModel",function($http,ConfigService,$q){
	var baseUrl="Cart";
	this.add = function(data){
		return $http.post(configService.getUrl(baseUrl)+"/AddProduct",data).then(function(res){
			if(typeof res.data =='object'){
				return res.data
			}
			else {
				$q.reject(res.data);
			}
		})
	}
});