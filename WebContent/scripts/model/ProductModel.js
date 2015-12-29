app.service("ProductModel",function($http,ConfigService){
	var baseUrl = "Products";
	this.getAll = function(){
		return $http.get(ConfigService.getUrl(baseUrl)).then(function(res){
			if(typeof res.data === 'object'){
				return res.data;
			}else {
				$q.reject(res.data);
			}
		});
	};
	
	this.addProduct= function(product){
		return $http.get(configService.getUrl(baseUrl)+"/AddProduct",product).then(function(res){
			if(typeof res.data =='object'){
				return res.data
			}
			else {
				$q.reject(res.data);
			}
		})
	}
	
});