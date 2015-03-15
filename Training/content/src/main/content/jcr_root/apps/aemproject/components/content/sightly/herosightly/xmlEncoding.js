"use strict";

use( function () {
    return {
        encodedValue: this.xssApi.encodeForXML(this.valueToEncode)
    };
});