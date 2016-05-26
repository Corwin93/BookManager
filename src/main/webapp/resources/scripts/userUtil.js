function _UserUtil() {

    this.deleteUser = function(nickName) {
        if (confirm("Are you sure?")) {
            window.location = "/deleteUser/" + nickName;
        }
    }
}

var UserUtil = new _UserUtil();