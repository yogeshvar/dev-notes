var a = [7,2,3,1,6,5,4];

for(var i = 0; i < a.length; i++) {
    var min = i;
    for(var j= min+1; j < a.length; j++) {
        if(a[j] < a[min]) {
            min = j; 
        }
    }
    var temp = a[i];
    a[i] = a[min];
    a[min] = temp;
}


console.log(a)
