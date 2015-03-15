"use strict";

use( function () {
	
	var pageName = currentPage.name;
	var title = currentPage.properties.get("jcr:title");
	var resourceName = granite.resource.name;
	var resourceTitle = properties.get("jcr:title");
	
    return {
        pageName: pageName,
        title: title,
        resourceName : resourceName,
        resourceTitle : resourceTitle
    };
});

