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
			items: [ ]
		});
		
		if(le.login){
			viewport.add(Ext.create('CERT.view.LoginPanel'));
			showIEWarning();
			//viewport.add(Ext.create('CERT.view.MainPanel'));
		} else {
			viewport.add(Ext.create('LE.view.MainPanel'));
		}
	}
});