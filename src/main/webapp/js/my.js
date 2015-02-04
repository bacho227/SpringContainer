var le = le || {};
var loc = loc || {};
var lang = 'ka';
loadExtCss();
loadLocale();
//window.localStorage = window.localStorage || {};

// loadExtCss();

function log() {
	if (document.all)
		return;
	console.log.apply(console, arguments);
}

function showIEWarning(){
	if(document.all)
		Ext.Msg.alert("ყურადღება", "პროგრამის სრულყოფილად ფუნქციონირებისათვის გამოიყენეთ შემდეგი ბრაუზერები: " +
				'<a href="https://www.google.com/chrome/browser/" target="_blank">Google Chrome</a> | ' +
				'<a href="https://www.mozilla.org/en-US/firefox/new/" target="_blank">Firefox</a> | ' + 
				'<a href="http://www.opera.com/" target="_blank">Opera</a>');
}

if (!document.all) {
	document.addEventListener('keydown', function(e) {
		if (e.which === 8 && e.target.tagName !== 'TEXTAREA' && e.target.tagName !== 'INPUT') {
			e.preventDefault();
		}
	});
}

// overrides //
var str = 'Ext.form.field.Text';

redefineFields('Ext.form.field.Text');
redefineFields('Ext.form.field.ComboBox');
redefineFields('Ext.form.field.TextArea');

function redefineFields(className) {
	Ext.define(className, {
		override : className,
		constructor : function(cfg) {
			cfg = cfg || {};
			var me = this;
			var isEng = cfg.isEng || me.isEng;
			var autoFocus = cfg.autoFocus || me.autoFocus;
			me.callParent(arguments);

			me.on({
				focus : function() {
					if(window.geokb) geokb.toggle(!isEng);
				}
			});
			if(autoFocus){
				me.on('afterrender', function(f){
					setTimeout(function(){
						f.focus();
					}, 300);
				});
			}

		}
	});
}

Ext.define('Ext.window.Window', {
	override: 'Ext.window.Window',
	constrain: true
});

Ext.define('Ext.form.Panel', {
	override : 'Ext.form.Panel',
	constructor : function(cfg) {
		cfg = cfg || {};
		var me = this;

		var fn = cfg.submitFn || me.submitFn;

		me.callParent(arguments);

		if (typeof fn === 'function') {
			me.addListener('afterrender', function() {
				me.keyNav = Ext.create('Ext.util.KeyNav', me.el, {
					enter : function(e) {
						if (me.getForm().isValid()) fn();
					}
				});
			});
		}
	}
});

Ext.define('Ext.grid.Panel', {
	override : 'Ext.grid.Panel',
	constructor : function(cfg) {
		cfg = cfg || {};
		var me = this;
		var countLabel = null;

		if (cfg.footer || me.footer) {
			countLabel = Ext.create('Ext.form.Label');

			me.bbar = [ {
				xtype : 'label',
				html : 'სულ: '
			}, countLabel ];
		}

		me.callParent(arguments);

		if (cfg.footer || me.footer) {
			me.getStore().on('datachanged', function() {
				var count = Math.max(me.getStore().getTotalCount(), me.getStore().getCount());
				countLabel.update(count.toString());
			});
		}
	}
});

// end overrides //

function loadExtCss() {
	var theme = localStorage.theme || 'neptune';
	loadCss("http://localhost/ext-5.1.0/build/packages/ext-theme-" + theme + "/build/resources/ext-theme-" + theme + "-all.css");
	//if (theme === 'ext-all-neptune')
	//	loadCss('./css/neptune.css');
	//else
	//	loadCss('./css/classic.css');
}

function loadCss(url) {
	// var link = document.createElement("link");
	// link.setAttribute("rel", "stylesheet");
	// link.setAttribute("href", url);
	// link.setAttribute("type", "text/css");

	var link = '<link href = "' + url + '" type="text/css" rel="stylesheet" />';
	// document.getElementsByTagName('head')[0].appendChild(link);
	document.write(link);
}

function monitorEvents(obj) {
	Ext.util.Observable.capture(obj, function(evname, args) {
		log(evname, [ args ]);
	});
}

function deleteProperties(obj, arr) {
	for ( var i in arr)
		delete obj[arr[i]];
	return obj;
}

function getDataFromStore(store, exclude) {
	return getDataFromRecords(store.getRange(), exclude);
}

function getDataFromRecords(records, exclude) {
	var arr = [];
	exclude = exclude || [];
	for ( var i in records) {
		var data = Ext.clone(records[i].getData());
		for ( var j in exclude) {
			delete data[exclude[j]];
		}
		arr.push(data);
	}
	return arr;
}

function correctDates(obj, arr) {
	arr = arr || [];
	// var newObj = Ext.clone(obj);
	for ( var i in arr) {
		if (obj[arr[i]]){
			obj[arr[i]] = new Date(dateToISOFormat(obj[arr[i]])).getTime();
		}
	}
}

function emptyString2Null(obj) {
	for ( var i in obj) {
		if (obj[i] === "" || obj[i] === undefined) {
			delete obj[i];
		} else if (obj[i].constructor === (new Object()).constructor) {
			emptyString2Null(obj[i]);
		} else if (obj[i].constructor === (new Array()).constructor) {
			for ( var j in obj[i]) {
				emptyString2Null(obj[i][j]);
			}
		}
	}
}

function myRequest(obj) {
	if (!obj.url)
		return;
	obj.method = obj.method || obj.type || 'POST';
	emptyString2Null(obj.data);

	var requestData = {
		url : obj.url,
		method : obj.method,
		params : obj.params,
		jsonData : obj.jsonData,
		callback : function(options, success, response) {
			if (success) {
				var res = response.responseText;
				try {
					res = response.responseText.replace(/\n/g, '');
					res = Ext.decode(res);
				} catch (e) {}
				if (typeof obj.callback == 'function')
					obj.callback(res);
			} else {
				switch(response.status){
				case 403:
					logout();
					break;
				default:					
					Ext.Msg.alert('Error', response.statusText);
					break;
				}
			}
		}
	};

	Ext.Ajax.request(requestData);

}

function relayoutWindows() {
	clearTimeout(window.relayoutWindowsT);
	window.relayoutWindowsT = setTimeout(function() {
		Ext.WindowManager.each(function(win) {
			if (typeof win.doLayout === 'function'){
				win.doLayout();
				win.center();
			}
		});
	}, 100);
}

window.onresize = relayoutWindows;

function dateToISOFormat(str){
	if(!str) return '';
	return str.substr(6) + '-' + str.substr(3, 2) + '-' + str.substr(0, 2);
}

function loadLocale(){
    lang = localStorage.lang || 'ka';
    var url = './js/locale/' + lang + '.js';
    if(lang == 'ka') Ext.Loader.loadScript('./js/ext-locale-ka_GE.js');

    Ext.Loader.loadScript(url);
}

function userLogout(){
	myRequest({
		url : 'rest/security/signout',
		callback : function() {
			location.href = 'login.html';
		}
	});
}

function adminLogout(){
	myRequest({
		url : '../rest/admin/security/signout',
		callback: function(){
			location.href = 'login.html';
		}
	});
}

function logout(){
	if(window.admin) adminLogout();
	else userLogout();
}

function changeTheme(theme){
    localStorage.theme = theme;
    Ext.Msg.confirm(loc.warning, loc.refreshWarning, function(ans){
        if(ans == 'yes'){
            location.reload();
        }
    });
}

function changeLang(lang){
    localStorage.lang = lang;
    Ext.Msg.confirm(loc.warning, loc.refreshWarning, function(ans){
        if(ans == 'yes'){
            location.reload();
        }
    });
}

// glyphs (icons)
window.g = {
    get: function (name) {
        return 'x' + name + '@FontAwesome';
    },
    edit: 'f044',
    history: 'f1da',
    back: 'f060',
    print: 'f02f',
    details: 'f013',
    groups: 'f0c0',
    documents: 'f1c6',
    'plus-circle': 'f055',
    file: 'f15b',
    save: 'f0c7',
    'chevron-circle-down': 'f13a',
    remove: 'f00d',
    'remove-circle': 'f00d',
    university: 'f19c',
    list: 'f03a',
    gears: 'f085',
    close: 'f00d',
    'check-circle': 'f058',
    'check': 'f00c',
    bell: 'f0f3',
    'thumbs-up': 'f164',
    'bar-chart': 'f080',
    tasks: 'f0ae',
    search: 'f002',
    refresh: 'f021',
    user: 'f007',
    'folder-open': 'f07c',
    'file-text': 'f15c',
    send: 'f1d8',
    eye: 'f06e',
    clients: 'f0c0',
    loans: 'f0d6',
    card: 'f09d'
};