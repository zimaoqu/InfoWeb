$(function()
{

	if (!window['console'])
	{
		window.console = {};
		window.console.log = function(){};
	}
		
	/*
	define a new language named "custom"
	*/


	$('#two-inputs').dateRangePicker(
	{
        showShortcuts: true,
        shortcuts :
            {
                'prev-days': [3,5,7],
                'prev': ['week','month','year'],
                'next-days':null,
                'next':null
            },
		separator : ' to ',
		getValue: function()
		{
			if ($('#date-range200').val() && $('#date-range201').val() )
				return $('#date-range200').val() + ' to ' + $('#date-range201').val();
			else
				return '';
		},
		setValue: function(s,s1,s2)
		{
			$('#date-range200').val(s1);
			$('#date-range201').val(s2);
		}
	});



});
