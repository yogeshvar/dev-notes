class Solution:
    def countMatches(self, items: List[List[str]], ruleKey: str, ruleValue: str) -> int:
        counter = 0
        for type_i,color_i,name_i in items:
            if ruleKey == "type" and type_i == ruleValue:
                counter += 1
            if ruleKey == "color" and color_i == ruleValue:
                counter += 1
            if ruleKey == "name" and name_i == ruleValue:
                counter += 1
        return counter