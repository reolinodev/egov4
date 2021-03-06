import DatePicker from 'tui-date-picker';
import 'tui-date-picker/dist/tui-date-picker.css';

export function setBasicDataRange (startName, endName, type) {

    let today = new Date();
    let beforeDate = new Date();
    if(type === 'today') {
        beforeDate = today;
    }else if(type === '1weeks'){
        beforeDate.setDate(beforeDate.getDate() -7);
    }else if(type === '1months'){
        beforeDate.setMonth(beforeDate.getMonth() -1);
    }else if(type === '1years'){
        beforeDate.setFullYear(beforeDate.getFullYear() -1);
    }else {
        beforeDate = null;
        today = null;
    }
    let dateRangeHtml = '<div id="dataPicker1" class="tui-datepicker-input tui-datetime-input tui-has-focus">\n'
        + '                 <input id="startpicker-input" style="font-size: 15px" type="text" aria-label="Date" name="'+startName+'">\n'
        + '                 <span class="tui-ico-date"></span>\n'
        + '                 <div id="startpicker-container" style="margin-left: -1px;"></div>\n'
        + '             </div>\n'
        + '             <span>~</span>\n'
        + '             <div id="dataPicker2" class="tui-datepicker-input tui-datetime-input tui-has-focus">\n'
        + '                 <input id="endpicker-input" style="font-size: 15px" type="text" aria-label="Date" name="'+endName+'">\n'
        + '                 <span class="tui-ico-date"></span>\n'
        + '                 <div id="endpicker-container" style="margin-left: -1px;"></div>\n'
        + '             </div>'
    $("#dateRange").html(dateRangeHtml);

    return DatePicker.createRangePicker({
        startpicker: {
            date: beforeDate,
            input: '#startpicker-input',
            container: '#startpicker-container'
        },
        endpicker: {
            date: today,
            input: '#endpicker-input',
            container: '#endpicker-container'
        },
    });
}