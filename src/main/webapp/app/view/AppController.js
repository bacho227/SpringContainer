/**
 * Created by bacho on 5/18/15.
 */
Ext.define('MI.view.AppController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.appController',

    //------------ LoginWindow functions ------------
    login: function () {
        var win = this.getView();
        var form = win.getLoginForm();
        if (!form.getForm().isValid())
            return;

        Ext.Ajax.request({
            url: 'rest/security/signIn',
            params: form.getForm().getValues(),
            success: function () {
                win.close();
                if (win.isLoginPage) {
                    location.href = "index.html";
                }
                else {
                    while (win.requestOptions.length > 0) {
                        var options = win.requestOptions.shift();
                        Ext.Ajax.request(options);
                    }
                }
            }
        });
    },

    //------------ Header functions ------------
    changeTheme: function (f, theme) {
        localStorage.theme = theme;
        Ext.Msg.confirm("გაფრთხილება", "საჭიროა გვერდის განახლება, გსურთ განახლება?", function (ans) {
            if (ans == 'yes') {
                location.reload();
            }
        });
    },

    //------------ Menu functions ------------
    menuItemClicked: function (button) {
        var menuPanel = this.getView();
        var mainTabPanel = menuPanel.getMainTabPanel();
        if (!button.mainItem || button.mainItem.isDestroyed) {
            button.mainItem = Ext.create(button.mainItemClass, {
                title: button.text,
                closable: true
            });
        }

        mainTabPanel.getLayout().setActiveItem(button.mainItem);
    },

    loadMainItem: function () {
        var menuPanel = this.getView();
        menuPanel.getMenu().down('[defaultItem=true]').fireHandler();
    }
});