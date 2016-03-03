function _BookUtil() {

    this.deleteBook = function(id) {
        if (confirm("Are you sure?")) {
            window.location = "/deletebook/" + id;
        }
    }
}

var BookUtil = new _BookUtil();