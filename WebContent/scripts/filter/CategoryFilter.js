var customfilter = angular.module("customFilter", []);
customfilter.filter("category", function() {

	return function(data, property) {

		console.log("category" + data);
		var filteredArray = [];

		if (!property) {
			return data;
		} else {
			return data.filter(function(element, index, array) {
				return element.category.id == property;
			});
		}
		
	}

})