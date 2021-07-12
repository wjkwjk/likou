package common;

import com.sun.org.apache.bcel.internal.generic.LNEG;

import java.util.HashMap;

/**
 * 146. LRU 缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 *
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * 使用循环链表+哈希表实现
 */

public class Solution146 {


}

class CirLinkedList{
    int key;
    int val;
    CirLinkedList pre;
    CirLinkedList next;

    public CirLinkedList() {
    }

    public CirLinkedList(int key, int val) {
        this.key = key;
        this.val = val;
    }

    public CirLinkedList(int key, int val, CirLinkedList pre, CirLinkedList next) {
        this.key = key;
        this.val = val;
        this.pre = pre;
        this.next = next;
    }
}

class LRUCache{

    CirLinkedList L = new CirLinkedList();
    HashMap<Integer, CirLinkedList> map = new HashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        L.next = L;
        L.pre = L;
    }

    public int get(int key) {
        if (this.map.containsKey(key)){
            CirLinkedList t = map.get(key);
            delete(t);
            insertHead(t);
            return t.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (this.map.containsKey(key)){
            CirLinkedList t = map.get(key);
            t.val = value;
            delete(t);
            insertHead(t);
        }
        else{
            if (this.capacity == 0){
                map.remove(L.pre.key);
                delete(L.pre);
                CirLinkedList t = new CirLinkedList(key, value);
                insertHead(t);
                map.put(key, t);
            }
            else{
                CirLinkedList t = new CirLinkedList(key, value);
                insertHead(t);
                map.put(key, t);
                this.capacity--;
            }
        }
    }

    private void insertHead(CirLinkedList t){
        t.next = L.next;
        t.pre = L;
        L.next.pre = t;
        L.next = t;
    }
    private void delete(CirLinkedList t){
        t.pre.next = t.next;
        t.next.pre = t.pre;
    }

}
