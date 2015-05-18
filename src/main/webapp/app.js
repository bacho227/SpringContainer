var MI = MI || {};

Ext.Loader.setConfig({
    enabled: true
});

Ext.Ajax.on({
    requestexception: function (req, resp, options) {
        switch (resp.status) {
            case 401:
                var loginWindow = Ext.ComponentQuery.query('loginWindow');
                if (loginWindow.length > 0) {
                    loginWindow = loginWindow[0];
                } else {
                    loginWindow = Ext.create('MI.view.LoginWindow');
                }
                loginWindow.addRequestOptions(options);
                break;
            case 500:
                var errText = resp.getResponseHeader('is-message') ? resp.responseText : getExceptionMessage(resp.responseText);
                Ext.Msg.alert('შეცდომა', errText);
                break;
            default:
                Ext.Msg.alert('შეცდომა', response.statusText);
                break;
        }
    }
});

Ext.get(window).on('resize', relayoutWindows);

Ext.application({
    name: 'MI',
    appFolder: 'app',
    requires: ['MI.view.AppController'],
    launch: function () {
        if (window.isLoginPage) {
            Ext.create('Ext.container.Viewport', {
                layout: 'fit'
            });
            Ext.create('MI.view.LoginWindow', {
                isLoginPage: true
            });
        } else {
            request({
                url: 'rest/security/getUser',
                success: function (user) {
                    MI.user = user;
                    Ext.create('MI.view.Viewport');
                }
            });
        }
    }
});