$(document).ready( function() {

    $('#statedrpdwn').append($('<option>', { value: -1, text: "--Select--"}));
    $('#districtdrpdwn').append($('<option>', { value: -1, text: "--Select--"}));
    $('#citydrpdwn').append($('<option>', { value: -1, text: "--Select--"}));

    $("#coutryDrpDnw").change(function() {
        let countryId = $('option:selected', this).val();
        $('#statedrpdwn').empty();
        $('#districtdrpdwn').empty();
        $('#citydrpdwn').empty();
        getStates(countryId);
    });

    $("#statedrpdwn").change(function() {
        let stateId = $('option:selected', this).val();
        $('#districtdrpdwn').empty();
        $('#citydrpdwn').empty();
        getDistrict(stateId);
    });

    $("#districtdrpdwn").change(function() {
        let districtId = $('option:selected', this).val();
        $('#citydrpdwn').empty();
        getCity(districtId);
    });

//    window.addEventListener('load', function() {
//        // Fetch the form we want to apply custom validation to
//        var form = document.getElementById('loginForm');
//        form.addEventListener('submit', function(event) {
//            if (form.checkValidity() === false) {
//                event.preventDefault();
//                event.stopPropagation();
//            }
//            form.classList.add('was-validated');
//        }, false);
//    }, false);

});

function getStates(pCountryId) {

    $('#statedrpdwn').append($('<option>', { value: -1, text: "--Select--"}));
    $('#districtdrpdwn').append($('<option>', { value: -1, text: "--Select--"}));
    $('#citydrpdwn').append($('<option>', { value: -1, text: "--Select--"}));

    $.ajax({
        type: 'GET',
        url: '/api/onGetStateByCountryId',
        contentType: 'application/json',
        data: {countryId:pCountryId},
        success: function(response) {
            if (response && response.length > 0) {
                response.forEach(function(state) {
                    $('#statedrpdwn').append($('<option>', {
                        value: state.id,
                        text: state.name
                    }));
                });
            } else {
                console.log('No states found');
            }
        },
        error: function(error) {
            console.log('Error: ' + error.responseText);
        }
    });
}

function getDistrict(pStateId) {

    $('#districtdrpdwn').append($('<option>', { value: -1, text: "--Select--"}));
    $('#citydrpdwn').append($('<option>', { value: -1, text: "--Select--"}));

    $.ajax({
        type: 'GET',
        url: '/api/onGetDistrictByStateId',
        contentType: 'application/json',
        data: {stateId:pStateId},
        success: function(response) {
            if (response && response.length > 0) {
                response.forEach(function(state) {
                    $('#districtdrpdwn').append($('<option>', {
                        value: state.id,
                        text: state.name
                    }));
                });
            } else {
                console.log('No states found');
            }
        },
        error: function(error) {
            console.log('Error: ' + error.responseText);
        }
    });
}

function getCity(pDistrictId) {

    $('#citydrpdwn').append($('<option>', { value: -1, text: "--Select--"}));

    $.ajax({
        type: 'GET',
        url: '/api/onGetCityByDistrictId',
        contentType: 'application/json',
        data: {districtId:pDistrictId},
        success: function(response) {
            if (response && response.length > 0) {
                response.forEach(function(state) {
                    $('#citydrpdwn').append($('<option>', {
                        value: state.id,
                        text: state.name
                    }));
                });
            } else {
                console.log('No states found');
            }
        },
        error: function(error) {
            console.log('Error: ' + error.responseText);
        }
    });
}

function onFindBloodDonor() {
    console.log("onFindBloodDonor");

    let bloodGroup = $("#bloodGroup").val();
    let coutryDrpDnw = $("#coutryDrpDnw").val();
    let statedrpdwn = $("#statedrpdwn").val();
    let districtdrpdwn = $("#districtdrpdwn").val();
    let citydrpdwn = $("#citydrpdwn").val();

    if (bloodGroup == "") {
        alert("Please select Blood Group");
        return;
    }

//    if (coutryDrpDnw == -1) {
//        alert("Please select Country");
//        return;
//    }

//    if (statedrpdwn == -1) {
//        alert("Please select State");
//        return;
//    }
//
//    if (districtdrpdwn == -1) {
//        alert("Please select Distric");
//        return;
//    }
//
//    if (citydrpdwn == -1) {
//        alert("Please select City");
//        return;
//    }

    const data = {
        bloodGroup: bloodGroup,
        coutry: coutryDrpDnw,
        state: statedrpdwn,
        district: districtdrpdwn,
        city: citydrpdwn,
    };

    $.ajax({
        url: '/onFindDonors',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function(response) {
            alert('Success: ' + response);
        },
        error: function(error) {
            alert('Error: ' + error.responseText);
        }
    });


}

