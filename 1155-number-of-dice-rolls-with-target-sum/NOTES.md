lets assume there are 'n' dice
take a dice what are choices it can have there are 'f' choices
explore all choices if recursive call will be after that choice i have to move to
next dice and target will become target-i(choice) .
whenever diceNum==totaldice and target is 0 return 1 because we got a way
else return false and take a case like if target becomes '0' or lessthan zero before diceNum equal to total dice  then return 0 becomes it's just waste of time and target never becomes positive .