window.onload = function () {
    var doc = document;
    var table = doc.getElementById("users_table");
    var trs = doc.getElementsByTagName("tr");
    for (var tr in trs) {
        trs[tr].onclick = function () {
            USERS.assign(this);
        }
    }
    FORM.init();
    var passCheckbox = doc.getElementById("pass_checkbox");
    passCheckbox.onclick = function () {
        FORM.togglePassword();
    }
};

var USERS = {
    currentUser: undefined,
    assign: function (tr) {
        var trIndex = tr.rowIndex - 1;
        var id = document.getElementsByClassName("id")[trIndex].innerHTML;
        var name = document.getElementsByClassName("firstName")[trIndex].innerHTML;
        var surname = document.getElementsByClassName("lastName")[trIndex].innerHTML;
        var login = document.getElementsByClassName("login")[trIndex].innerHTML;
        var email = document.getElementsByClassName("email")[trIndex].innerHTML;
        var role = document.getElementsByClassName("role")[trIndex].innerHTML;
        this.currentUser = new User(id, name, surname, login, email, role);
        this.currentUser.show();
    }
};

function User(id, firstName, lastName, login, email, role) {
    this.show = function () {
        FORM.newValues(id, firstName, lastName, login, email, role);
    }
}

var FORM = {
    fields: undefined,
    init: function () {
        var user_form = document.getElementById("user_form");
        var id = user_form.getElementsByTagName("input")[0];
        var firstName = user_form.getElementsByTagName("input")[1];
        var lastName = user_form.getElementsByTagName("input")[2];
        var role = user_form.getElementsByTagName("select")[0];
        var login = user_form.getElementsByTagName("input")[3];
        var email = user_form.getElementsByTagName("input")[4];
        this.fields = {
            id: id,
            firstName: firstName,
            lastName: lastName,
            login: login,
            email: email,
            role: role
        }
    },
    newValues: function (id, firstName, lastName, login, email, role) {
        this.fields.id.value = id;
        this.fields.firstName.value = firstName;
        this.fields.lastName.value = lastName;
        this.fields.login.value = login;
        this.fields.email.value = email;
        this.fields.role.selectedIndex = ROLES[role];
    },
    togglePassword: function () {
        var password = document.getElementById("password");
        if (password.style.visibility === "hidden")
            password.style.visibility = "visible";
        else
            password.style.visibility = "hidden";
    }
};

var ROLES = {
    "USER": 0,
    "ADMIN": 1
};

function logoutSubmit() {
    document.getElementById("logoutForm").submit();
}
