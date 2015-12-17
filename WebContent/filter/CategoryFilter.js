var customfilter = angular.module("customFilter", []);
customfilter.filter("category", function() {

	return function(data, property) {
		if (angular.isArray(data)) {
			alert(data);
			var keys={};
			var filteredArray = [];
			for ( var i = 0; i < data.length; i++) {

				var value = data[i][property];
				
				alert(value);
				if (angular.isUndefined(keys[value])) {
					keys[value] = true;
					filteredArray.push(value);
				}

			}

			return filteredArray
		} else {
			return data;
		}

	}

})