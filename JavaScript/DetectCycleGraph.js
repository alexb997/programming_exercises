// Given the root of a Directed graph,
//  The task is to check whether the graph contains a cycle or not.

function hasCycle(graph, node, visited, recStack) {
    if (recStack.has(node)) return true;
    if (visited.has(node)) return false;

    visited.add(node);
    recStack.add(node);

    for (let neighbor of graph[node] || []) {
        if (hasCycle(graph, neighbor, visited, recStack)) return true;
    }

    recStack.delete(node);
    return false;
}

function isCyclic(graph) {
    const visited = new Set();
    const recStack = new Set();

    for (let node in graph) {
        if (!visited.has(node)) {
            if (hasCycle(graph, node, visited, recStack)) return true;
        }
    }
    return false;
}

function main() {
    const graph1 = {
        0: [1],
        1: [2],
        2: [3],
        3: [1]
    };

    const graph2 = {
        0: [1, 2],
        1: [2],
        2: [3],
        3: []
    };

    console.log("Does 1 have a cycle?", isCyclic(graph1));
    console.log("Does 2 have a cycle?", isCyclic(graph2));
}

main();
