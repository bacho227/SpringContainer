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

function login(form){
    myRequest({
        url: 'rest/security/signIn',
        params: {
            username: form.elements.username.value,
            password: form.elements.password.value
        },
        callback: function(user){
            le.user = user;
			localStorage.leUserName = user.username;
			//localStorage.leFullName = user.name + ' ' + user.surname;
			location.href = "index.html";

            log(user);
        }
    });
    return false;
}

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
			var headers = response.getAllResponseHeaders();
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
                case 500:
					var errText = headers['le-message'] ? response.responseText : getExceptionMessage(response.responseText);
                    Ext.Msg.alert('შეცდომა', errText);
                    break;
				default:
					Ext.Msg.alert('შეცდომა', response.statusText);
					break;
				}
			}
		}
	};

	Ext.Ajax.request(requestData);

}

function getExceptionMessage(s){
    s = s.substr(s.indexOf("Exception:") + 0);
    s = s.substr(s.indexOf(":") + 2, s.indexOf("h1") - 13);
    log(s);
    return s;
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
		url : 'rest/security/signOut',
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
    user: 'f007',
    edit: 'f044',
    history: 'f1da',
    back: 'f060',
    print: 'f02f',
    details: 'f013',
    groups: 'f0c0',
    documents: 'f1c6',
    plusCircle: 'f055',
    file: 'f15b',
    save: 'f0c7',
    chevronCircleDown: 'f13a',
    remove: 'f00d',
    removeCircle: 'f00d',
    university: 'f19c',
    list: 'f03a',
    gears: 'f085',
    close: 'f00d',
    checkCircle: 'f058',
    check: 'f00c',
    bell: 'f0f3',
    thumbsUp: 'f164',
    barChart: 'f080',
    tasks: 'f0ae',
    search: 'f002',
    refresh: 'f021',
    user: 'f007',
    folderOpen: 'f07c',
    fileText: 'f15c',
    send: 'f1d8',
    eye: 'f06e',
    clients: 'f0c0',
    loans: 'f0d6',
    card: 'f09d',
    logout: 'f08b',
    brush: 'f1fc'
};