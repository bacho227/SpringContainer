Ext.define('LE.view.LoginPanel', {
	extend : 'Ext.panel.Panel',
	layout : 'fit',
	constructor : function(cfg) {
		cfg = cfg || {};
		var me = this;
        me.callParent(arguments);

		var form = Ext.create('Ext.form.Panel', {
			border : false,
			bodyPadding : 5,
			submitFn : login,
			fieldDefaults : {
				labelWidth : 110,
				labelAlign : 'right',
				anchor : '100%',
				allowBlank : false
			},
			items : [ {
				xtype : 'textfield',
				fieldLabel : loc.login.username,
				name : 'username',
				isEng : true,
				autoFocus : true
			}, {
                xtype: 'textfield',
                inputType: 'password',
                name: 'password',
                fieldLabel: loc.login.password
            } ]
		});

		Ext.create('Ext.window.Window', {
			modal : true,
			autoShow : true,
			width : 300,
			title : loc.login.authorization,
			closable : false,
			draggable : false,
			layout : 'fit',
			items : [ form ],
			buttons : ['->', {
				text : loc.login.login,
				handler : login
			} ]
		});

		me.callParent(arguments);


		function login() {
            if (!form.getForm().isValid())
                return;
            var values = form.getForm().getValues();
            myRequest({
                url: 'rest/security/signIn',
                params: values,
                callback: function (response) {
                    var msg = '';
                    switch (response.message) {
                        case "SUCCESSFUL":
                            sessionStorage.leUserName = values.username;
                            sessionStorage.leFullName = response.firstName + ' ' + response.lastName;
                            location.href = "index.html";
                            break;
                        case "EMPTY_USER_PASSWORD":
                            msg = 'მიუთითეთ პაროლი';
                            break;
                        case "BAD_USER":
                            msg = 'ასეთი მომხმარებელი არ არსებობს! გთხოვთ გაიაროთ რეგისტრაცია!';
                            break;
                        case "BAD_PASSWORD":
                            msg = 'არასწორი პაროლი';
                            break;
                    }
                    if (msg) {
                        Ext.Msg.alert(loc.error, msg);
                    }
                }
            });
        }
	}
});