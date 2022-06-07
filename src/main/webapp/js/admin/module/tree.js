import Tree from 'tui-tree';

/**
 * setBasicGrid : 기본 그리드 생성
 * columns: 컬럼, gridData : 데이터
 */
export function setBasicTree (data) {

    data = data2

    console.log('aaa', data);

    return new Tree('#tree', {
        data: data,
        nodeDefaultState: 'opened'
    });
}

var util = {
    addEventListener: function(element, eventName, handler) {
        if (element.addEventListener) {
            element.addEventListener(eventName, handler, false);
        } else {
            element.attachEvent('on' + eventName, handler);
        }
    }
};

var data2 = [
    {text: 'rootA', children: [
            {text: 'sub-A1'},
            {text: 'sub-A2'},
            {text: 'sub-A3'},
            {text: 'sub-A4'},
            {text: 'sub-A7'},
            {text: 'sub-A8'},
            {text: 'sub-A10'},
            {text: 'sub-A11'},
            {text: 'sub-A12'}
        ]},
    {text: 'rootB', children: [
            {text:'sub-B1'},
            {text:'sub-B2'},
            {text:'sub-B3'}
        ]}
];



// var addChildBtn = document.getElementById('addChildBtn');
// var removeChildBtn = document.getElementById('removeChildBtn');
// var sortBtn = document.getElementById('sortBtn');
// var rootNodeId = tree.getRootNodeId();
// var firstChildId = tree.getChildIds(rootNodeId)[0];
//
// util.addEventListener(addChildBtn, 'click', function() {
//     tree.add({text:'hello world'}, firstChildId);
// });
//
// util.addEventListener(removeChildBtn, 'click', function() {
//     var lastGrandChildId = tree.getChildIds(firstChildId).slice(-1)[0];
//     tree.remove(lastGrandChildId);
// });
//
// util.addEventListener(sortBtn, 'click', function() {
//     tree.sort(function(nodeA, nodeB) {
//         var aValue = nodeA.getData('text'),
//             bValue = nodeB.getData('text');
//
//         if (!aValue.localeCompare) {
//             return 0;
//         }
//         return aValue.localeCompare(bValue);
//     });
// });