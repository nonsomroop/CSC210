function search (pattern) {
    var puzzle2D = document.getElementById("puzzleTable");
    var height = puzzle2D.rows.length;
    var width = puzzle2D.rows[0].cells.length;
    patternLength = pattern.length;
    
    for (let i = 0; i < height; i++){
        for (let j = 0; j < width; j++){
            //case1
            if (j <= width - patternLength){
                let k = 0;
                while (k < patternLength && puzzle2D.rows[i].cells[j + k].textContent == pattern.toUpperCase()[k]){
                    k++;
                } 
                if (k == patternLength){
                    var foundAt = "[" + i + ", " + j + "] to the right";
                    break;
                }
            }
            //case2
            if (j >= patternLength - 1){
                let k = 0;
                while (k < patternLength && puzzle2D.rows[i].cells[j - k].textContent == pattern.toUpperCase()[k]){
                    k++;
                } 
                if (k == patternLength){
                    var foundAt = "[" + i + ", " + j + "] to the left";
                    break;
                }
            }
            //case3
            if (i <= height - patternLength){
                let k = 0;
                while (k < patternLength && puzzle2D.rows[i + k].cells[j].textContent == pattern.toUpperCase()[k]){
                    k++;
                } 
                if (k == patternLength){
                    var foundAt = "[" + i + ", " + j + "] to the bottom";
                    break;
                }
            }
            //case4
            if (i >= patternLength - 1){
                let k = 0;
                while (k < patternLength && puzzle2D.rows[i - k].cells[j].textContent == pattern.toUpperCase()[k]){
                    k++;
                } 
                if (k == patternLength){
                    var foundAt = "[" + i + ", " + j + "] to the top";
                    break;
                }
            }
            //case5
            if (j <= width - patternLength && i <= height - patternLength){
                let k = 0;
                while (k < patternLength && puzzle2D.rows[i + k].cells[j + k].textContent == pattern.toUpperCase()[k]){
                    k++;
                } 
                if (k == patternLength){
                    var foundAt = "[" + i + ", " + j + "] to the diagonal bottom right";
                    break;
                }
            }
            //case6
            if (j <= width - patternLength && i >= patternLength - 1){
                let k = 0;
                while (k < patternLength && puzzle2D.rows[i - k].cells[j + k].textContent == pattern.toUpperCase()[k]){
                    k++;
                } 
                if (k == patternLength){
                    var foundAt = "[" + i + ", " + j + "] to the diagonal top right";
                    break;
                }
            }
            //case7
            if (j >= patternLength - 1 && i >= patternLength - 1){
                let k = 0;
                while (k < patternLength && puzzle2D.rows[i - k].cells[j - k].textContent == pattern.toUpperCase()[k]){
                    k++;
                } 
                if (k == patternLength){
                    var foundAt = "[" + i + ", " + j + "] to the diagonal top left";
                    break;
                }
            }
            //case8
            if (j >= patternLength - 1 && i <= height - patternLength){
                let k = 0;
                while (k < patternLength && puzzle2D.rows[i + k].cells[j - k].textContent == pattern.toUpperCase()[k]){
                    k++;
                } 
                if (k == patternLength){
                    var foundAt = "[" + i + ", " + j + "] to the diagonal bottom left";
                    break;
                }
            }
        }
    }
    if (foundAt) {
        alert(foundAt);
    } else {
        alert("not found");
    }
}