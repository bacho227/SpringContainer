var le = le || {};

Ext.Loader.setConfig({
	enabled: true
});

Ext.application({
	name: 'LE',
	appFolder: 'app',
	launch: function(){
		
		var viewport = Ext.create('Ext.container.Viewport', {
			layout: 'fit',
            border: false
		});
        //viewport.setLoading(true);
        myRequest({
            url: 'rest/security/getUser',
            callback: function(user){
                if(!user) location.href = 'login.html';
                le.user = user;
                viewport.setLoading(false);
                viewport.add(Ext.create('LE.view.MainPanel'));
            }
        });
	}
});