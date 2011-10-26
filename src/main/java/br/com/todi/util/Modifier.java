package br.com.todi.util;

import java.util.Collection;

public class Modifier {

	public static <T> void modify(Collection<T> list, Transformation<T> transformation) {
		for (T obj : list) {
			transformation.each(obj);
		}
	}
}
