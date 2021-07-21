/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// THIS CODE IS AUTOMATICALLY GENERATED.  DO NOT EDIT.

package org.apache.kafka.common.metadata;

import java.util.ArrayList;
import java.util.List;
import org.apache.kafka.common.Uuid;
import org.apache.kafka.common.protocol.ApiMessage;
import org.apache.kafka.common.protocol.MessageSizeAccumulator;
import org.apache.kafka.common.protocol.MessageUtil;
import org.apache.kafka.common.protocol.ObjectSerializationCache;
import org.apache.kafka.common.protocol.Readable;
import org.apache.kafka.common.protocol.Writable;
import org.apache.kafka.common.protocol.types.CompactArrayOf;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.protocol.types.RawTaggedField;
import org.apache.kafka.common.protocol.types.RawTaggedFieldWriter;
import org.apache.kafka.common.protocol.types.Schema;
import org.apache.kafka.common.protocol.types.Type;
import org.apache.kafka.common.utils.ByteUtils;

import static org.apache.kafka.common.protocol.types.Field.TaggedFieldsSection;


public class PartitionChangeRecord implements ApiMessage {
    int partitionId;
    Uuid topicId;
    List<Integer> isr;
    int leader;
    private List<RawTaggedField> _unknownTaggedFields;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("partition_id", Type.INT32, "The partition id."),
            new Field("topic_id", Type.UUID, "The unique ID of this topic."),
            TaggedFieldsSection.of(
                0, new Field("isr", CompactArrayOf.nullable(Type.INT32), "null if the ISR didn't change; the new in-sync replicas otherwise."),
                1, new Field("leader", Type.INT32, "-1 if there is now no leader; -2 if the leader didn't change; the new leader otherwise.")
            )
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0
    };
    
    public static final short LOWEST_SUPPORTED_VERSION = 0;
    public static final short HIGHEST_SUPPORTED_VERSION = 0;
    
    public PartitionChangeRecord(Readable _readable, short _version) {
        read(_readable, _version);
    }
    
    public PartitionChangeRecord() {
        this.partitionId = -1;
        this.topicId = Uuid.ZERO_UUID;
        this.isr = null;
        this.leader = -2;
    }
    
    @Override
    public short apiKey() {
        return 5;
    }
    
    @Override
    public short lowestSupportedVersion() {
        return 0;
    }
    
    @Override
    public short highestSupportedVersion() {
        return 0;
    }
    
    @Override
    public void read(Readable _readable, short _version) {
        this.partitionId = _readable.readInt();
        this.topicId = _readable.readUuid();
        {
            this.isr = null;
        }
        this.leader = -2;
        this._unknownTaggedFields = null;
        int _numTaggedFields = _readable.readUnsignedVarint();
        for (int _i = 0; _i < _numTaggedFields; _i++) {
            int _tag = _readable.readUnsignedVarint();
            int _size = _readable.readUnsignedVarint();
            switch (_tag) {
                case 0: {
                    int arrayLength;
                    arrayLength = _readable.readUnsignedVarint() - 1;
                    if (arrayLength < 0) {
                        this.isr = null;
                    } else {
                        ArrayList<Integer> newCollection = new ArrayList<Integer>(arrayLength);
                        for (int i = 0; i < arrayLength; i++) {
                            newCollection.add(_readable.readInt());
                        }
                        this.isr = newCollection;
                    }
                    break;
                }
                case 1: {
                    this.leader = _readable.readInt();
                    break;
                }
                default:
                    this._unknownTaggedFields = _readable.readUnknownTaggedField(this._unknownTaggedFields, _tag, _size);
                    break;
            }
        }
    }
    
    @Override
    public void write(Writable _writable, ObjectSerializationCache _cache, short _version) {
        int _numTaggedFields = 0;
        _writable.writeInt(partitionId);
        _writable.writeUuid(topicId);
        if (this.isr != null) {
            _numTaggedFields++;
        }
        if (this.leader != -2) {
            _numTaggedFields++;
        }
        RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
        _numTaggedFields += _rawWriter.numFields();
        _writable.writeUnsignedVarint(_numTaggedFields);
        if (isr != null) {
            _writable.writeUnsignedVarint(0);
            _writable.writeUnsignedVarint(_cache.getArraySizeInBytes(this.isr));
            _writable.writeUnsignedVarint(isr.size() + 1);
            for (Integer isrElement : isr) {
                _writable.writeInt(isrElement);
            }
        }
        {
            if (this.leader != -2) {
                _writable.writeUnsignedVarint(1);
                _writable.writeUnsignedVarint(4);
                _writable.writeInt(leader);
            }
        }
        _rawWriter.writeRawTags(_writable, Integer.MAX_VALUE);
    }
    
    @Override
    public void addSize(MessageSizeAccumulator _size, ObjectSerializationCache _cache, short _version) {
        int _numTaggedFields = 0;
        _size.addBytes(4);
        _size.addBytes(16);
        if (isr == null) {
        } else {
            _numTaggedFields++;
            _size.addBytes(1);
            int _sizeBeforeArray = _size.totalSize();
            _size.addBytes(ByteUtils.sizeOfUnsignedVarint(isr.size() + 1));
            _size.addBytes(isr.size() * 4);
            int _arraySize = _size.totalSize() - _sizeBeforeArray;
            _cache.setArraySizeInBytes(isr, _arraySize);
            _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_arraySize));
        }
        if (this.leader != -2) {
            _numTaggedFields++;
            _size.addBytes(1);
            _size.addBytes(1);
            _size.addBytes(4);
        }
        if (_unknownTaggedFields != null) {
            _numTaggedFields += _unknownTaggedFields.size();
            for (RawTaggedField _field : _unknownTaggedFields) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.tag()));
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.size()));
                _size.addBytes(_field.size());
            }
        }
        _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PartitionChangeRecord)) return false;
        PartitionChangeRecord other = (PartitionChangeRecord) obj;
        if (partitionId != other.partitionId) return false;
        if (!this.topicId.equals(other.topicId)) return false;
        if (this.isr == null) {
            if (other.isr != null) return false;
        } else {
            if (!this.isr.equals(other.isr)) return false;
        }
        if (leader != other.leader) return false;
        return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + partitionId;
        hashCode = 31 * hashCode + topicId.hashCode();
        hashCode = 31 * hashCode + (isr == null ? 0 : isr.hashCode());
        hashCode = 31 * hashCode + leader;
        return hashCode;
    }
    
    @Override
    public PartitionChangeRecord duplicate() {
        PartitionChangeRecord _duplicate = new PartitionChangeRecord();
        _duplicate.partitionId = partitionId;
        _duplicate.topicId = topicId;
        if (isr == null) {
            _duplicate.isr = null;
        } else {
            ArrayList<Integer> newIsr = new ArrayList<Integer>(isr.size());
            for (Integer _element : isr) {
                newIsr.add(_element);
            }
            _duplicate.isr = newIsr;
        }
        _duplicate.leader = leader;
        return _duplicate;
    }
    
    @Override
    public String toString() {
        return "PartitionChangeRecord("
            + "partitionId=" + partitionId
            + ", topicId=" + topicId.toString()
            + ", isr=" + ((isr == null) ? "null" : MessageUtil.deepToString(isr.iterator()))
            + ", leader=" + leader
            + ")";
    }
    
    public int partitionId() {
        return this.partitionId;
    }
    
    public Uuid topicId() {
        return this.topicId;
    }
    
    public List<Integer> isr() {
        return this.isr;
    }
    
    public int leader() {
        return this.leader;
    }
    
    @Override
    public List<RawTaggedField> unknownTaggedFields() {
        if (_unknownTaggedFields == null) {
            _unknownTaggedFields = new ArrayList<>(0);
        }
        return _unknownTaggedFields;
    }
    
    public PartitionChangeRecord setPartitionId(int v) {
        this.partitionId = v;
        return this;
    }
    
    public PartitionChangeRecord setTopicId(Uuid v) {
        this.topicId = v;
        return this;
    }
    
    public PartitionChangeRecord setIsr(List<Integer> v) {
        this.isr = v;
        return this;
    }
    
    public PartitionChangeRecord setLeader(int v) {
        this.leader = v;
        return this;
    }
}
