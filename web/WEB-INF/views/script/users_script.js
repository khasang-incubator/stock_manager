window.onload = function () {
    var doc = document;
    var table = doc.getElementById("users_table");
    var trs = doc.getElementsByTagName("tr");
    for (var tr in trs) {
        trs[tr].onclick = function () {
            USERS.asign(this);

        }
    }
    FORM.init();
    var passCheckbox = doc.getElementById("pass_checkbox");
    passCheckbox.onclick = function () {
        FORM.togglePassword();
    }
}

var USERS = {
    currentUser: undefined,
    asign: function (tr) {
        var trIndex = tr.rowIndex - 1;
        var id = document.getElementsByClassName("id")[trIndex].innerHTML;
        var name = document.getElementsByClassName("name")[trIndex].innerHTML;
        var role = document.getElementsByClassName("role")[trIndex].innerHTML;
        var login = document.getElementsByClassName("login")[trIndex].innerHTML;
        var email = document.getElementsByClassName("email")[trIndex].innerHTML;
        this.currentUser = new User(id, name, role, login, email);
        this.currentUser.show();
    }
}

function User(id, name, role, login, email) {
    this.show = function () {
        FORM.newValues(id, name, role, login, email);
    }
}

var FORM = {
    fields: undefined,
    init: function () {
        var user_form = document.getElementById("user_form");
        var id = user_form.getElementsByTagName("input")[0];
        var name = user_form.getElementsByTagName("input")[1];
        var role = user_form.getElementsByTagName("select")[0];
        var login = user_form.getElementsByTagName("input")[3];
        var email = user_form.getElementsByTagName("input")[4];
        this.fields = {
            id: id,
            name: name,
            role: role,
            login: login,
            email: email
        }
    },
    newValues: function (id, name, role, login, email) {
        this.fields.id.value = id;
        this.fields.name.value = name;
        this.fields.role.selectedIndex = ROLES[role];
        this.fields.login.value = login;
        this.fields.email.value = email;
    },
    togglePassword: function () {
        var password = document.getElementById("password");
        if (password.style.visibility === "hidden")
            password.style.visibility = "visible";
        else
            password.style.visibility = "hidden";
    }
}

var ROLES = {
    "USER": 0,
    "ADMIN": 1
}