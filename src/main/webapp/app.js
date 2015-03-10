var le = le || {};

var myIp = localStorage.getItem('myIp');
log(myIp)
if (myIp) {
	Ext.Loader.setConfig({
		enabled: true,
		paths: {
			'LE': myIp + '/app'
		}
	});
}
Ext.application({
	name: (myIp ? '' : 'LE'),
	appFolder: 'app',
	launch: function () {

		var viewport = Ext.create('Ext.container.Viewport', {
			layout: 'fit',
			border: false
		});
		//viewport.setLoading(true);
		myRequest({
			url: 'rest/security/getUser',
			callback: function (user) {
				if (!user) location.href = 'login.html';
				le.user = user;
				viewport.setLoading(false);
				viewport.add(Ext.create('LE.view.MainPanel'));
			}
		});
	}
});