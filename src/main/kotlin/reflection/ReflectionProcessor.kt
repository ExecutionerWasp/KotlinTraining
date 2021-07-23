package reflection

import java.util.*

class ReflectionProcessor {

    @SuppressWarnings("unchecked")
    fun <S : Any, O : ArrayList<Any>> invokeWithAnnotation(obj: S, annotation: Class<Any>, args: O): Any? {
        if (Objects.nonNull(obj)) {
            obj::class.java.methods.forEach {
                if (it.isAnnotationPresent(annotation as Class<Annotation>)) {
                    return if ((Objects.isNull(args) && it.parameterCount == 0) || it.parameterCount == args.size){
                        it.invoke(obj)
                    } else {
                        it.invoke(obj, args)
                    }
                }
            }
            return null
        } else {
            throw NullPointerException("Object: ${obj::class.java.simpleName} is null")
        }
    }

}
