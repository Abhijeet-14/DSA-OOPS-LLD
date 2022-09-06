
ab = document.getElementsByTagName("details");
_json = {};
for (let i = 0; i < ab.length; i++) _json[i] = ab[i].children[0].innerText;

var new_json = {};
Object.keys(_json).forEach(function (key) {
  if (_json[key] == "") new_json[key] = _json[key];
});

var keys = Object.keys(new_json);
var keys_json = Object.keys(_json);

var ans = [];
var _dict_ans = {};

for (let idx = 0; idx < keys_json.length; idx++) {
  let i = keys_json[idx];
  let len = ab[i].children.length;
  let _topic = _json[i];
  for (let j = 0; j < len; j++) {
    tagName = ab[i]?.children[j]?.tagName;
    if (tagName == "DETAILS") {
      _details(ab[i]?.children[j], _topic);
    } else if (tagName == "TABLE") {
      _tables(ab[i]?.children[j], _topic);
    }
  }
}

function _details(element, _topic) {
  func = "_details()";
  table = element?.children[1];
  console.log(func + " " + _topic + " 1: ", table);
  _tables(table, _topic);
}

function _tables(element, _topic) {
  func = "_tables()";
  let tbody = element?.children[1];

  let tbody_len = tbody?.children?.length;
  console.log(func + " " + _topic + " 1: ", tbody);
  console.log(func + " " + _topic + " 2: ", tbody_len);

  for (let i = 0; i < tbody_len; i++) {
    td_lc = tbody?.children[i]?.children[4];
    td_gfg = tbody?.children[i]?.children[2];
    td_question_name = tbody?.children[i]?.children[1].innerText;
    console.log(func + " " + _topic + " 3: ", td_lc);
    extract_link(td_lc, td_question_name, _topic);
    extract_link(td_gfg, td_question_name, _topic);
  }
}

function extract_link(element, quest_name, _topic) {
  func = "extract_link()";
  console.log(func + " " + _topic + " 1: ", element);
  _link = element?.children[0]?.getAttribute("href");
  console.log(func + " " + _topic + " link: ", _link);
  if (_link != null) {
    ans.push(_link);
    if(_dict_ans[_link] == undefined)
        _dict_ans[_link] = quest_name + _topic;
    else
        _dict_ans[_link] = _dict_ans[_link] + _topic;
  }
}
