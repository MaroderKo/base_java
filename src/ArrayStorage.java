import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size;

    void clear() {// пройшли по масиву і занулили усе що є
        for (int i = 0; i < size; i++) {
            storage[i] = null;
            size = 0;// занулили лічильник
        }
    }

    void save(Resume r) {
        if (Objects.isNull(r)) {
                return;
        }//провірка if (r !==null)
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(r.uuid)) {//перевіряємо чи є однакове резюме в масиві
                return;
            }
        }
        storage[size] = r;
        size++;

    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null; //якщо знайшли рівні uuid
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {// пройшли по масиву
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[size - 1]; //перезаписуємо на місце того що удаляємо кінцевий елемент масиву
                storage[size - 1] = null; // навірняка занулюємоостанній
                size--; //зменьшуємо розмір ліста на один
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] rezalt = new Resume[size]; //створюємо новий масів з розмірністю яка получилася
        for (int i = 0; i < size; i++) {
            rezalt[i] = storage[i]; //переназиваємо масив
        }
        return rezalt;
    }

    int size() {
        return size;
    }
}
