import Tree from 'tui-tree';

/**
 * setBasicTree : 기본 트리 생성
 * data : 트리 데이터
 */
export function setBasicTree (data) {

    // if(data.length === 0){
    //     $("#tree").html("-- No Data --");
    // }else {
    //     return new Tree('#tree', {
    //         data: data,
    //         nodeDefaultState: 'opened'
    //     }).enableFeature('Selectable', {
    //         selectedClassName: 'tui-tree-selected',
    //     });
    // }

    var util = {
        addEventListener: function(element, eventName, handler) {
            if (element.addEventListener) {
                element.addEventListener(eventName, handler, false);
            } else {
                element.attachEvent('on' + eventName, handler);
            }
        }
    }

    var tree = new Tree('#tree', {
        data: data,
        nodeDefaultState: 'opened'
    }).enableFeature('Selectable', {
        selectedClassName: 'tui-tree-selected',
    });

    var selectedBtn = document.getElementById('selectedBtn');
    var deselectedBtn = document.getElementById('deselectedBtn');
    var rootNodeId = tree.getRootNodeId();
    var firstChildId = tree.getChildIds(rootNodeId)[0];
    var selectedValue = document.getElementById('selectedValue');

    tree.on('select', function(eventData) {
        console.log('aaa', eventData);
        var nodeData = tree.getNodeData(eventData.nodeId);
        console.log('ccc', nodeData);
    });


    return tree;
}

