var le = le || {};

Ext.Loader.setConfig({
	enabled: true
});

Ext.application({
	name: 'LE',
	appFolder: 'app',
	launch: function(){
		
		Ext.create('Ext.container.Viewport', {
			layout: 'fit',
			items: [ window.login ? Ext.create('LE.view.LoginPanel') : Ext.create('LE.view.MainPanel') ]
		});

	}
});