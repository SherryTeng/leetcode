package RobloxOA;
//Your task is to implement an inventory tracking system for a robot retail store.
//        You are given a transaction log Togs , where each log item corresponds to one of three transaction types: supply ,se11 , or upgrade . Log items are provided in the following format:
//        ["supply",<robot name>","<count>","<price>"] the store receives <count>units of <robot name> and each robot costs<price> .
//        ["sell" ,"<robot name> ","<count>"] the store sells <count> units of <robotname> if the specified robot is available at different prices the cheapest ones should be sold first. it is guaranteed that the store will always have enough robots to satisfy all sell transactions.
//        ["upgrade","<robot name>", "<count>", "<old price", "new price"] - the store upgrades <count> units of <robot name> to a new version that should be sold with a higher price. it is guaranteed that there are<count>units of older version that were being sold at price <old price>
//The tracking system should return the revenue from all sell transactions after processing the entire transaction log. Specifically, return an array representing the amount of money the store received from each sell transaction
//
//        logs =
//        [ ["supply", "robot1", "2", "100"],
//        ["supply", "robot2", "3", "60"],
//        ["sell", "robot1", "1"],
//        ["sell", "robot2", "1"],
//        ["upgrade", "robot2", "1", "60", "100"],
//        ["sell", "robot2", "1"],
//        ["sell", "robot2", "1"]]
//        the output should be
//        solution(logs) = [100, 60, 60, 100]

public class implementARobot {

}
