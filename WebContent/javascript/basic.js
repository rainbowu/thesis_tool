
$(document).ready(function(){
	$('#decryptData').submit(function(){
		
		$.ajax({
			url: 'update',
			type: 'POST',
			dataType:'json',
			data: $('#decryptData').serialize(),
			success: function(data){
				if(data.isValid){
					$('#displayData').html('Decrypted Info is: ' + data.enigma);
					$('#displayData').slideDown(500);
				}else
					alert('please enter a valid username!');
			}
		});
		
		
		return false;
	});
	
});