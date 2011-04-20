/**
 * Generated by Gas3 v2.2.0 (Granite Data Services).
 *
 * WARNING: DO NOT CHANGE THIS FILE. IT MAY BE OVERWRITTEN EACH TIME YOU USE
 * THE GENERATOR. INSTEAD, EDIT THE INHERITED CLASS (Author.as).
 */

package br.com.caelum.testeGranite.model {

    import flash.events.EventDispatcher;
    import flash.utils.IDataInput;
    import flash.utils.IDataOutput;
    import flash.utils.IExternalizable;
    import flash.utils.getQualifiedClassName;
    import mx.core.IUID;
    import mx.data.utils.Managed;
    import mx.utils.UIDUtil;
    import org.granite.collections.IPersistentCollection;
    import org.granite.meta;
    import org.granite.tide.IEntity;
    import org.granite.tide.IEntityManager;
    import org.granite.tide.IPropertyHolder;

    use namespace meta;

    [Managed]
    public class AuthorBase implements IExternalizable, IUID {

        [Transient]
        meta var entityManager:IEntityManager = null;

        private var __initialized:Boolean = true;
        private var __detachedState:String = null;

        private var _book:Book;
        private var _firstName:String;
        private var _id:Number;
        private var _lastName:String;

        meta function isInitialized(name:String = null):Boolean {
            if (!name)
                return __initialized;

            var property:* = this[name];
            return (
                (!(property is Author) || (property as Author).meta::isInitialized()) &&
                (!(property is IPersistentCollection) || (property as IPersistentCollection).isInitialized())
            );
        }
        
        [Bindable(event="dirtyChange")]
		public function get meta_dirty():Boolean {
			return Managed.getProperty(this, "meta_dirty", false);
		}

        public function set book(value:Book):void {
            _book = value;
        }
        public function get book():Book {
            return _book;
        }

        public function set firstName(value:String):void {
            _firstName = value;
        }
        public function get firstName():String {
            return _firstName;
        }

        public function set id(value:Number):void {
            _id = value;
        }
        [Id]
        public function get id():Number {
            return _id;
        }

        public function set lastName(value:String):void {
            _lastName = value;
        }
        public function get lastName():String {
            return _lastName;
        }

        public function set uid(value:String):void {
            // noop...
        }
        public function get uid():String {
            if (isNaN(_id))
                return UIDUtil.createUID();
            return getQualifiedClassName(this) + "#[" + String(_id) + "]";
        }

        meta function merge(em:IEntityManager, obj:*):void {
            var src:AuthorBase = AuthorBase(obj);
            __initialized = src.__initialized;
            __detachedState = src.__detachedState;
            if (meta::isInitialized()) {
               em.meta_mergeExternal(src._book, _book, null, this, 'book', function setter(o:*):void{_book = o as Book}, false);
               em.meta_mergeExternal(src._firstName, _firstName, null, this, 'firstName', function setter(o:*):void{_firstName = o as String}, false);
               em.meta_mergeExternal(src._id, _id, null, this, 'id', function setter(o:*):void{_id = o as Number}, false);
               em.meta_mergeExternal(src._lastName, _lastName, null, this, 'lastName', function setter(o:*):void{_lastName = o as String}, false);
            }
            else {
               em.meta_mergeExternal(src._id, _id, null, this, 'id', function setter(o:*):void{_id = o as Number});
            }
        }

        public function readExternal(input:IDataInput):void {
            __initialized = input.readObject() as Boolean;
            __detachedState = input.readObject() as String;
            if (meta::isInitialized()) {
                _book = input.readObject() as Book;
                _firstName = input.readObject() as String;
                _id = function(o:*):Number { return (o is Number ? o as Number : Number.NaN) } (input.readObject());
                _lastName = input.readObject() as String;
            }
            else {
                _id = function(o:*):Number { return (o is Number ? o as Number : Number.NaN) } (input.readObject());
            }
        }

        public function writeExternal(output:IDataOutput):void {
            output.writeObject(__initialized);
            output.writeObject(__detachedState);
            if (meta::isInitialized()) {
                output.writeObject((_book is IPropertyHolder) ? IPropertyHolder(_book).object : _book);
                output.writeObject((_firstName is IPropertyHolder) ? IPropertyHolder(_firstName).object : _firstName);
                output.writeObject((_id is IPropertyHolder) ? IPropertyHolder(_id).object : _id);
                output.writeObject((_lastName is IPropertyHolder) ? IPropertyHolder(_lastName).object : _lastName);
            }
            else {
                output.writeObject(_id);
            }
        }
    }
}