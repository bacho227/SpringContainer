Ext.define('MI.view.LoginWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.loginWindow',
    controller: 'appController',
    modal: true,
    autoShow: true,
    title: 'ავტორიზაცია',
    closable: false,
    draggable: false,
    resizable: false,
    requestOptions: [],
    constructor: function (cfg) {
        cfg = cfg || {};
        var me = this;

        var loginButton = Ext.create('Ext.button.Button', {
            text: 'შესვლა',
            handler: 'login'
        });

        var loginForm = Ext.create('Ext.form.Panel', {
            border: false,
            bodyPadding: 5,
            submitBtn: loginButton,
            fieldDefaults: {
                labelWidth: 110,
                labelAlign: 'right',
                anchor: '100%',
                allowBlank: false
            },
            items: [{
                xtype: 'textfield',
                fieldLabel: 'მომხმარებელი',
                name: 'username',
                readOnly: !cfg.isLoginPage,
                value: MI.user ? MI.user.username : 'test',
                autoFocus: true
            }, {
                xtype: 'textfield',
                inputType: 'password',
                name: 'password',
                value: 'test',
                fieldLabel: 'პაროლი'
            }]
        });

        me.items = [loginForm];

        me.buttons = ['->', loginButton];

        me.getLoginForm = function () {
            return loginForm;
        };
        me.addRequestOptions = function (options) {
            me.requestOptions.push(options);
        };

        me.callParent(arguments);


    }
});