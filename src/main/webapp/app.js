var le = le || {};

Ext.Loader.setConfig({
	enabled: true
});

Ext.application({
	name: 'LE',
	appFolder: 'app',
	launch: function(){
		
		var viewport = Ext.create('Ext.container.Viewport', {
			layout: 'fit'
		});

        myRequest({
            url: 'rest/security/getUser',
            callback: function(user){
                le.user = user;
                viewport.add(Ext.create('LE.view.MainPanel'));
            }
        });
	}
});