package JZOffer;

import java.util.*;

/**
 * @ProjectName: project
 * @Package: JZOffer
 * @ClassName: NumBusesToDestination815
 * @Author: hp
 * @Date: 28/06/2021 10:40
 * @Version: 1.0
 * @Description:
 */
public class NumBusesToDestination815 {
    // 建立邻接表，保存车到车之间是否存在直线的连线，也就是可以直接换成
    Map<Integer, Set<Integer>> bus2buses = new HashMap<>();
    // 保存车经过哪些站台, key是车, value是站台
    Map<Integer, Set<Integer>> bus2stations = new HashMap<>();
    // 保存站台有哪些车经过, key是站台, value是车
    Map<Integer, List<Integer>> station2buses = new HashMap<>();
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;

        int n = routes.length;
        int res = n + 1;

        // 初始化两个映射
        for(int i = 0; i < n; i++) {
            bus2buses.put(i, new HashSet<>());
            bus2stations.put(i, new HashSet<>());
        }

        // 初始化两个映射
        for(int i = 0; i < n; i++) { // 遍历所有车
            for(int r : routes[i]) { // 当前车经过的站台
                if(!station2buses.containsKey(r)) { // station2buses未添加到hash表中
                    station2buses.put(r, new ArrayList<>()); // 添加站r并初始化
                }
                station2buses.get(r).add(i); // 将i车加入站r的列表
                bus2stations.get(i).add(r); // 将r车加入站i的列表
            }
        }

        // 不存在target站
        if (!station2buses.containsKey(target)) return -1;

        // 填入车与车之间的直接关系
        for(int s : station2buses.keySet()) {
            for(int i = 0; i < station2buses.get(s).size(); i++) {
                bus2buses.get(station2buses.get(s).get(i)).addAll(station2buses.get(s));
            }
        }

        // 遍历当前站台为出发点的所有车，作为dfs的出发车辆
        for(int cur : station2buses.get(source)) {
            // 存放经过出发站台的当前车辆，以及经过目的站台的所有车辆
            Set<Integer> start = new HashSet<>(), end = new HashSet<>();
            // 当前车辆加入起点集合
            start.add(cur);
            // 加入终点集合
            end.addAll(station2buses.get(target));
            // 如果当前车辆的路线中已经包含了目标站台，那么只乘一次车
            if(bus2stations.get(cur).contains(target)) return 1;
            // 广度优先搜索比较
            res = Math.min(res, bfs(start, end, 2, n));
        }
        return res == n + 1 ? -1 : res;
    }

    // 广度优先搜索，参数分别代表起点集合、终点集合、当前搜索的深度、最大深度
    private int bfs(Set<Integer> start, Set<Integer> end, int len, int max) {
        // 没有车辆或者
        if(start.size() == 0 || len > max) return max + 1;
        Set<Integer> next = new HashSet<>();
        // 枚举所有车辆
        for(int cur : start) {
            // 该车与其他车辆无连线
            if(!bus2buses.containsKey(cur)) continue;
            // 枚举与当前车辆有连线的所有车辆
            for(int b : bus2buses.get(cur)) {
                // 如果当前车要经过目标车站，那么可以返回长度
                if(end.contains(b)) return len;
                    // 不然需要将当前车辆放到下一个起点集合中再进行搜索
                else next.add(b);
            }
        }
        return bfs(next, end, len + 1, max);
    }
}
