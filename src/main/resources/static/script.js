const button = document.getElementById('wpButton');
let image = document.getElementById('image');
let imageURL = image.src;

button.setAttribute('href', 'whatsapp://send?text='+encodeURIComponent(imageURL));
