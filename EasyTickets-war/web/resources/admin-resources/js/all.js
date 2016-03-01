var ETAdmin = {};
ETAdmin.ajax = function (type) {
    if (type === 'login') {
        this.ajax.login();
    }
};
ETAdmin.ajax.login = function () {
    var username = $('input[name="username"]').val();
    var password = $('input[name="password"]').val();
    if (username !== '' && password !== '') {
        ETAdmin.result('', '#result', '<center><img src="dist/img/ajax-loading.gif" alt="Loading" width="32"/></center>');
    } else {
        username === '' ? $('input[name="username"]').focus() : $('input[name="password"]').focus();
        ETAdmin.result('warning', '#result', 'Please input username and password to login');
    }
};

ETAdmin.result = function (type, component, content) {
    var html = '';
    if (type === 'success') {
        html = '<div class="alert alert-success">' + content + '</div>';
    } else if (type === 'info') {
        html = '<div class="alert alert-info">' + content + '</div>';
    } else if (type === 'warning') {
        html = '<div class="alert alert-warning">' + content + '</div>';
    } else if (type === 'error') {
        html = '<div class="alert alert-danger">' + content + '</div>';
    } else {
        html = content;
    }
    $(component).html(html);
};

ETAdmin.clean = function (component) {
    $(component).empty();
};