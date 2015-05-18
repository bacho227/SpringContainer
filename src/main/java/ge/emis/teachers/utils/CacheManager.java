package ge.emis.teachers.utils;

import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.AbstractCacheManager;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bacho on 3/19/15.
 */
public class CacheManager extends AbstractCacheManager {
	public static final String MAIN_MENU = "MAIN_MENU";
	public static final String CUSTOMER_TYPE = "CUSTOMER_TYPE";
	public static final String CUSTOMER_FIN_SEC = "CUSTOMER_FIN_SEC";
	public static final String CUSTOMER_ATTR_TYPE = "CUSTOMER_ATTR_TYPE";
	public static final String COL_ATTR_TYPE = "COL_ATTR_TYPE";
	public static final String GEN_PARAM = "GEN_PARAM";

	@Override
	protected List<ConcurrentMapCache> loadCaches() {
		List<ConcurrentMapCache> concurrentCaches = new ArrayList();
		Field[] declaredFields = CacheManager.class.getDeclaredFields();
		try {
			for (Field field : declaredFields) {
				int modifiers = field.getModifiers();
				if (Modifier.isFinal(modifiers) && Modifier.isStatic(modifiers) && Modifier.isPublic(modifiers)) {
					field.setAccessible(true);
					String cacheName = (String) field.get(null);
					concurrentCaches.add(new ConcurrentMapCache(cacheName));
				}
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return concurrentCaches;
	}
}
