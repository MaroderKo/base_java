package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO implement
// TODO create new MapStorage with search key not uuid
public class MapNameStorage extends AbstractStorage {
    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected String getSearchKey(String fullname) {

        for (Map.Entry ent :
                map.entrySet()) {
            if (((Resume)ent.getValue()).getFullName().equals(fullname))
            {
                return (String) ent.getKey();
            }
        }
        return null;
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        map.put((String) searchKey,r);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return map.containsKey(searchKey);
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {
        map.put((String) searchKey,r);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return map.get(searchKey);
    }

    @Override
    protected void doDelete(Object searchKey) {
        map.remove(searchKey);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = new ArrayList<>(map.values());
        list.sort((o1, o2) -> (o1.getUuid().compareTo(o2.getUuid()) == 0 ? o1.getUuid().compareTo(o2.getUuid()) : o1.getUuid().compareTo(o2.getUuid())));
        return list;
    }


    @Override
    public int size() {
        return map.size();
    }
}
