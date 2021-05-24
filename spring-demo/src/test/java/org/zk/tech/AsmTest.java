package org.zk.tech;

import org.junit.Test;
import org.springframework.asm.AnnotationVisitor;
import org.springframework.asm.ClassReader;
import org.springframework.asm.ClassVisitor;
import org.springframework.asm.Type;
import org.zk.config.AppConfig;

import static org.springframework.asm.Opcodes.ASM4;

public class AsmTest {

	@Test
	public void test1() throws Exception {
		ClassPrint classPrint = new ClassPrint(ASM4);
		ClassReader classReader = new ClassReader(AppConfig.class.getName());
		classReader.accept(classPrint, 2);
	}

	static class ClassPrint extends ClassVisitor {

		public ClassPrint(int i) {
			super(i);
		}

		@Override
		public AnnotationVisitor visitAnnotation(String desc, boolean b) {
			String className = Type.getType(desc).getClassName();
			AnnotationVisitor annotationVisitor = super.visitAnnotation(desc, b);
			return annotationVisitor;
		}
	}
}
